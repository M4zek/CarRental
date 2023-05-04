import { useState } from "react";
import { SmallText } from "../components/atoms/SmallText/SmallText";
import FormField from "../components/molecules/FormField/FormField";
import FormIcon from "../components/atoms/FormIcon/FormIcon";
import { Button } from "../components/atoms/Button/Button";
import Input from "../components/atoms/Input/Input";
import Padlock from '../assets/icons/padlock.svg';
import Person from '../assets/icons/person.svg';
import { Link } from 'react-router-dom';

const Login = ({ endpoint }) => {

  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');

  return (
    <>
      <FormField>
        <FormIcon endpoint={endpoint}></FormIcon>
        <Input iconSrc={Person} placeholderText="Username" name="userName" id="userName" value={userName} onChange={(e) => setUserName(e.target.value)} type="text" />
        <Input iconSrc={Padlock} placeholderText="Password" name="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} type="password" />
        <Button isGold isBig isMarginTop>Login</Button>
        <SmallText>
          You don’t have account? <Link to="/register">Sign up now!</Link>
        </SmallText>
      </FormField>
    </>
  )
}

export default Login;