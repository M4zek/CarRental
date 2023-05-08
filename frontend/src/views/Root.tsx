import AuthenticatedApp from "./AuthenticatedApp";
import UnauthenticatedApp from "./UnauthenticatedApp";
import { useAuth } from '../hooks/useAuth';

const Root = () => {

  const auth = useAuth();
  
  return auth.user ? <AuthenticatedApp /> : <UnauthenticatedApp />
}

export default Root;
