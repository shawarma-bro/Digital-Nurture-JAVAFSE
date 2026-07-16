package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    private static StockRepository stockRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        stockRepository = context.getBean(StockRepository.class);

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testSearchByName();
        testSearchByNameSorted();
        testSearchByStartingLetter();
        testGetStockByMonthAndCode();
        testGetGoogleStockAbovePrice();
        testGetTop3HighestVolume();
        testGetTop3LowestNetflix();
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    private static void testAddCountry() {
        LOGGER.info("Start");
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Test Country");
        countryService.addCountry(country);
        try {
            Country fetched = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added Country:{}", fetched);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start");
        try {
            countryService.updateCountry("ZZ", "Updated Test Country");
            Country updated = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated Country:{}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("ZZ");
        LOGGER.debug("Country ZZ deleted");
        LOGGER.info("End");
    }

    private static void testSearchByName() {
        LOGGER.info("Start");
        List<Country> result = countryService.searchByName("ou");
        LOGGER.debug("Countries containing 'ou': {}", result);
        LOGGER.info("End");
    }

    private static void testSearchByNameSorted() {
        LOGGER.info("Start");
        List<Country> result = countryService.searchByNameSorted("ou");
        LOGGER.debug("Countries containing 'ou' sorted: {}", result);
        LOGGER.info("End");
    }

    private static void testSearchByStartingLetter() {
        LOGGER.info("Start");
        List<Country> result = countryService.searchByStartingLetter("Z");
        LOGGER.debug("Countries starting with Z: {}", result);
        LOGGER.info("End");
    }

    private static void testGetStockByMonthAndCode() {
        LOGGER.info("Start");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse("2019-09-01");
            Date end = sdf.parse("2019-09-30");
            List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", start, end);
            LOGGER.debug("FB September 2019 stocks: {}", stocks);
        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    private static void testGetGoogleStockAbovePrice() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        LOGGER.debug("Google stocks above 1250: {}", stocks);
        LOGGER.info("End");
    }

    private static void testGetTop3HighestVolume() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 highest volume: {}", stocks);
        LOGGER.info("End");
    }

    private static void testGetTop3LowestNetflix() {
        LOGGER.info("Start");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Netflix top 3 lowest close: {}", stocks);
        LOGGER.info("End");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.debug("Skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setName("David");
        employee.setSalary(65000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());
        Department dept = departmentService.get(1);
        employee.setDepartment(dept);
        employeeService.save(employee);
        LOGGER.debug("Saved Employee:{}", employee);
        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        Department newDept = departmentService.get(2);
        employee.setDepartment(newDept);
        employeeService.save(employee);
        LOGGER.debug("Updated Employee:{}", employee);
        LOGGER.info("End");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start");
        Department department = departmentService.get(1);
        LOGGER.debug("Department:{}", department);
        LOGGER.debug("Employees in department:{}", department.getEmployeeList());
        LOGGER.info("End");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(2);
        Skill skill = skillService.get(1);
        Set<Skill> skills = employee.getSkillList();
        skills.add(skill);
        employee.setSkillList(skills);
        employeeService.save(employee);
        LOGGER.debug("Employee after adding skill:{}", employee);
        LOGGER.info("End");
    }
}
