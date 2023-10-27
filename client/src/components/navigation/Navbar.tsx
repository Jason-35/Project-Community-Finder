import { NavbarBrand } from "./NavbarBrand";
import { NavbarButtons } from "./NavbarButton";
import { NavbarTabs } from "./NavbarTabs";
import "../../styles/components/Navbar.css";
export const Navbar = () => {
  return (
    <div className="navbar-container">
      <nav className="navbar">
        <NavbarBrand />
        <NavbarTabs />
        <div className="last">
          <NavbarButtons />
        </div>
      </nav>
    </div>
  );
};
