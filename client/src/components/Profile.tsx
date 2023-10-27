import { useAuth0 } from "@auth0/auth0-react";
import { useEffect, useState } from "react";
import axios from "axios";
const Profile = () => {
  const { user, isAuthenticated, getAccessTokenSilently } = useAuth0();
  const [token, setToken] = useState<string>();

  //user info
  console.log(user);

  //get token after user logs in
  useEffect(() => {
    const getToken = async () => {
      if (isAuthenticated) {
        const res = await getAccessTokenSilently({
          authorizationParams: {
            scope: "openid profile email delete:friend_request",
          },
        });
        setToken(res);

        console.log(res);
        try {
          const response = await axios.get(
            "http://localhost:8080/auth0/private",
            {
              headers: {
                Authorization: `Bearer ${res}`,
              },
            }
          );

          console.log(response.data);
        } catch (error) {
          console.log(error);
        }
      }
    };
    getToken();
  }, [getAccessTokenSilently, isAuthenticated]);

  return (
    <>
      {isAuthenticated && (
        <article className="column">Hello {user?.name}</article>
      )}
    </>
  );
};

export default Profile;
