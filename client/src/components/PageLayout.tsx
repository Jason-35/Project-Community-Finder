import { Navbar } from "./navigation/Navbar";
import { PageFooter } from "./Footer";
import "../styles/components/PageLayout.css";

export const PageLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <div className="page-layout">
      <Navbar />
      <div className="page-layout-content">{children}</div>
      {/* <PageFooter /> */}
    </div>
  );
};
