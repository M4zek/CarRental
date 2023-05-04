import { useState, useContext } from 'react';
import { Link } from "react-router-dom";
import { SmallText } from "../components/atoms/SmallText/SmallText";
import FormField from "../components/molecules/FormField/FormField";
import FormIcon from "../components/atoms/FormIcon/FormIcon";
import { Button } from "../components/atoms/Button/Button";
import Input from "../components/atoms/Input/Input";
import Padlock from '../assets/icons/padlock.svg';
import Person from '../assets/icons/person.svg';
import { AppContext } from './Root';
import axios from "axios";

const Login = ({ endpoint }) => {

  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');

  const { setAuthData } = useContext(AppContext);

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/auth/authenticate', {
        username: userName,
        password: password,
      });
      setAuthData({
        user: {
          firstname: response.data.firstName,
          lastname: response.data.lastName
        }
      });
      // console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <FormField handleSubmit={handleSubmit}>
      <FormIcon endpoint={endpoint}></FormIcon>
      <Input iconSrc={Person} placeholderText="Username" name="userName" id="userName" value={userName} onChange={(e) => setUserName(e.target.value)} type="text" />
      <Input iconSrc={Padlock} placeholderText="Password" name="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} type="password" />
      <Button type="submit" isGold isBig isMarginTop>Login</Button>
      <SmallText>
        You don’t have account? <Link to="/register">Sign up now!</Link>
      </SmallText>
    </FormField>
  )
}

export default Login;