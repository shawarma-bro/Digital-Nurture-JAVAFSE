import React, { Component } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      view: 'book',
      showBlog: true
    };
  }

  renderWithIfElse() {
    if (this.state.view === 'book') {
      return <BookDetails />;
    } else if (this.state.view === 'course') {
      return <CourseDetails />;
    } else {
      return <p>No view selected</p>;
    }
  }

  renderWithSwitch() {
    switch (this.state.view) {
      case 'book':
        return <BookDetails />;
      case 'blog':
        return <BlogDetails />;
      case 'course':
        return <CourseDetails />;
      default:
        return <p>Nothing to show</p>;
    }
  }

  render() {
    let elementVariable;
    if (this.state.view === 'blog') {
      elementVariable = <BlogDetails />;
    } else {
      elementVariable = <p>Select Blog to view element variable output</p>;
    }

    return (
      <div>
        <h1>Blogger App</h1>
        <button onClick={() => this.setState({ view: 'book' })}>Book</button>
        <button onClick={() => this.setState({ view: 'blog' })}>Blog</button>
        <button onClick={() => this.setState({ view: 'course' })}>Course</button>
        <button onClick={() => this.setState({ showBlog: !this.state.showBlog })}>
          Toggle Blog Visibility
        </button>

        <h3>1. Conditional Rendering with if-else</h3>
        {this.renderWithIfElse()}

        <h3>2. Conditional Rendering with switch-case</h3>
        {this.renderWithSwitch()}

        <h3>3. Conditional Rendering with Ternary Operator</h3>
        {this.state.view === 'course' ? <CourseDetails /> : <p>This is not the course view</p>}

        <h3>4. Conditional Rendering with && Operator</h3>
        {this.state.showBlog && <BlogDetails />}

        <h3>5. Conditional Rendering with Element Variable</h3>
        {elementVariable}
      </div>
    );
  }
}

export default App;
