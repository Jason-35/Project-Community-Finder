
import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { Auth0Provider } from '@auth0/auth0-react'

const domain = import.meta.env.VITE_AUTH0_DOMAIN;
const clientId = import.meta.env.VITE_AUTH0_CLIENT_ID;

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <Auth0Provider domain={domain} clientId={clientId} authorizationParams={{
      redirect_uri: window.location.origin,
      audience: `https://${domain}/api/v2/`,
      scope: "openid profile email"
    }}>

      <App />
    </Auth0Provider>

  </React.StrictMode>,
)