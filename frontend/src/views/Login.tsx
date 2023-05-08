import { useState } from 'react';
import { Link } from "react-router-dom";
import { ErrorMessage } from '../components/atoms/ErrorMessage/ErrorMessage';
import { SmallText } from "../components/atoms/SmallText/SmallText";
import FormField from "../components/molecules/FormField/FormField";
import FormIcon from "../components/atoms/FormIcon/FormIcon";
import { Button } from "../components/atoms/Button/Button";
import Input from "../components/atoms/Input/Input";
import Padlock from '../assets/icons/padlock.svg';
import Person from '../assets/icons/person.svg';
import { useAuth } from '../hooks/useAuth';


const Login = ({ endpoint }) => {
  
  const auth = useAuth();
  const [username, setUserName] = useState('');
  const [password, setPassword] = useState('');
  
  const handleSubmit = async (event) => {
    event.preventDefault();
    await auth.signIn({ username, password });
  }

  return (
    <FormField handleSubmit={handleSubmit}>
      <FormIcon endpoint={endpoint}></FormIcon>
      {auth.error && <ErrorMessage>{auth.error}</ErrorMessage>}
      <Input iconSrc={Person} placeholderText="Username" name="username" id="username" value={username} onChange={(e) => setUserName(e.target.value)} type="text" />
      <Input iconSrc={Padlock} placeholderText="Password" name="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} type="password" />
      <Button type="submit" isGold isBig isMarginTop>Login</Button>
      <SmallText>
        You don’t have account? <Link to="/register">Sign up now!</Link>
      </SmallText>
    </FormField>
  )
}

export default Login;