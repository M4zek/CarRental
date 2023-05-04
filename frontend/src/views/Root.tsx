import { createContext, useContext } from 'react';
import AuthenticatedApp from "./AuthenticatedApp";
import UnauthenticatedApp from "./UnauthenticatedApp";
import { useLocation } from "react-router-dom";

export const AppContext = createContext({
  currentPath: '/',
  user: null,
  // user: {
  //   name: 'Jan Kowalski',
  // },
});

const Root = () => {
  
  const location = useLocation();
  const currentPath = location.pathname;
  const { user } = useContext(AppContext);

  return (
    <AppContext.Provider value={{ currentPath, user }}>
      {user ? <AuthenticatedApp /> : <UnauthenticatedApp />}
    </AppContext.Provider>
  )
}

export default Root;
