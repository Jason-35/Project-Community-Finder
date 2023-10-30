import "./App.css";
import { useAuth0 } from "@auth0/auth0-react";
import { Routes, Route } from "react-router-dom";
import { AuthenticationGuard } from "./components/auth/AuthenticationGuard";
import HomePage from "./pages/HomePage";
import ProfilePage from "./pages/ProfilePage";
import NotFoundPage from "./pages/NotFoundPage";
import RoomPage from "./pages/RoomPage";
import CallbackPage from "./pages/CallbackPage";

function App() {
  const { isLoading, error } = useAuth0();

  if (isLoading) {
    return <div>Loading</div>;
  }
  return (
    <>
      <Routes>
        <Route path="/" element={<HomePage></HomePage>}></Route>
        <Route
          path="/profile"
          element={<AuthenticationGuard component={ProfilePage} />}
        />
        <Route
          path="/room"
          element={<AuthenticationGuard component={RoomPage} />}
        />
        <Route path="/callback" element={<CallbackPage />} />
        <Route path="*" element={<NotFoundPage />} />
      </Routes>
    </>
  );
}

export default App;
