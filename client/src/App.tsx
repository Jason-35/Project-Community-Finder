import "./App.css";
import HomePage from "./components/HomePage";

import { useAuth0 } from "@auth0/auth0-react";
import { Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";

function App() {
  const { isLoading, error } = useAuth0();

  if (isLoading) {
    return <div>Loading</div>;
  }
  return (
    <>
      <Navbar></Navbar>
      <Routes>
        <Route path="/" element={<HomePage></HomePage>}></Route>
      </Routes>
    </>
  );
}

export default App;
