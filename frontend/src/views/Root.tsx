import { createContext, useState } from 'react';
import AuthenticatedApp from "./AuthenticatedApp";
import UnauthenticatedApp from "./UnauthenticatedApp";

export const AppContext = createContext({
  currentPath: null,
  user: null,
  setAuthData: () => {},
});

const Root = () => {

  const [authData, setAuthData] = useState({});

  return (
    <AppContext.Provider value={{ ...authData, setAuthData }}>
      {authData.user ? <AuthenticatedApp /> : <UnauthenticatedApp />}
    </AppContext.Provider>
  )
}

export default Root;
