import { useAuth0 } from "@auth0/auth0-react";
import { Navbar } from "../components/navigation/Navbar";
import { PageLayout } from "../components/PageLayout";
import "../styles/components/Navbar.css";
import "../styles/components/PageLayout.css";

const CallbackPage = () => {
  const { error } = useAuth0();

  if (error) {
    return (
      <PageLayout>
        <div className="content-layout">
          <h1 id="page-title" className="content-title">
            Error
          </h1>
          <div className="content-body">
            <p id="page-description">
              <span>{error.message}</span>
            </p>
          </div>
        </div>
      </PageLayout>
    );
  }

  return (
    <div className="page-layout">
      <Navbar />
      <div className="page-layout-content" />
    </div>
  );
};

export default CallbackPage;
