import { NavLink } from "react-router-dom";
import logo from "../../assets/board-svgrepo-com.svg";
export const NavbarBrand = () => {
  return (
    <div className="navbar-brand">
      <NavLink to="/">
        <img
          className="navbar-logo"
          src={logo}
          alt="logo"
          width="122"
          height="36"
        />
      </NavLink>
    </div>
  );
};
