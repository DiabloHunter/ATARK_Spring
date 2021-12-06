import React,{useState, useEffect} from "react";
import './App.css';
import './components/Appbar.js';
import { BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";


export default function App() {
  return (
    <Router>
      <div>
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
      </div>
      <Routes>
        <Route path="/" element={<Home/>}>
        </Route>
        <Route path="/about" element={<About/>}>
        </Route>
      </Routes>
    </Router>
  );
}

function Home() {
  return <h2>Home</h2>;
}

function About() {
  return <h2>About</h2>;
}

function Users() {
  return <h2>Users</h2>;
}