import Profile from "./Profile";
import { useAuth0 } from "@auth0/auth0-react";

const HomePage = () => {
  const { error } = useAuth0();

  return (
    <>
      {!error && (
        <>
          <Profile></Profile>
        </>
      )}
    </>
  );
};

export default HomePage;
