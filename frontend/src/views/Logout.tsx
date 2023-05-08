import { useAuth } from "../hooks/useAuth";

const LogoutPage = () => {
  const auth = useAuth();
  
  return auth.logOut();
}

export default LogoutPage;