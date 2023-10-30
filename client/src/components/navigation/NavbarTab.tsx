import { NavLink } from "react-router-dom";

type TabProps = {
  path: string;
  label: string;
};

export const NavbarTab = ({ path, label }: TabProps) => {
  return (
    <NavLink
      to={path}
      end
      className={({ isActive }) =>
        "navbar-tab " + (isActive ? "navbar-tab--active" : "")
      }
    >
      {label}
    </NavLink>
  );
};
