import { useAuth0 } from "@auth0/auth0-react";
import { NavbarTab } from "./NavbarTab";

export const NavbarTabs = () => {
  const { isAuthenticated } = useAuth0();

  return (
    <div className="navbar-tabs">
      <NavbarTab path="/" label="Home" />
      {isAuthenticated && (
        <>
          <NavbarTab path="/profile" label="Profile" />
          <NavbarTab path="/room" label="Room" />
        </>
      )}
    </div>
  );
};
