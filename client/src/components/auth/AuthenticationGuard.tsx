import { withAuthenticationRequired } from "@auth0/auth0-react";

interface AuthenticationGuardProp {
  component: React.ComponentType;
}

export const AuthenticationGuard = ({ component }: AuthenticationGuardProp) => {
  const Component = withAuthenticationRequired(component, {
    onRedirecting: () => (
      <div className="page-layout">
        <div>Loading</div>
      </div>
    ),
  });

  return <Component />;
};
