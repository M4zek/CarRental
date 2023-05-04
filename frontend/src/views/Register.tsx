import { useState } from "react"
import { SmallText } from "../components/atoms/SmallText/SmallText";
import FormField from "../components/molecules/FormField/FormField";
import FormIcon from "../components/atoms/FormIcon/FormIcon";
import { Button } from "../components/atoms/Button/Button";
import Input from "../components/atoms/Input/Input";
import Padlock from "../assets/icons/padlock.svg";
import Person from "../assets/icons/person.svg";
import idCard from "../assets/icons/id-card.svg";
import Email from "../assets/icons/email.svg";
import { Link } from "react-router-dom";

const Register = ({ endpoint }) => {

  const [firstName, setFirstName] = useState('');
  const [surname, setSurName] = useState('');
  const [email, setEmail] = useState('');
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const [confirmpassword, setConfirmPassword] = useState('');

  return (
    <>
      <FormField>
        <FormIcon endpoint={endpoint}></FormIcon>
        <Input iconSrc={Person} placeholderText="Firstname" name="firstName" id="firstName" value={firstName} onChange={(e) => setFirstName(e.target.value)} type="text" />
        <Input iconSrc={Person} placeholderText="Surname" name="surname" id="surname" value={surname} onChange={(e) => setSurName(e.target.value)} type="text" />
        <Input iconSrc={Email} placeholderText="Email" name="email" id="email" value={email} onChange={(e) => setEmail(e.target.value)} type="email" />
        <Input iconSrc={idCard} placeholderText="Username" name="userName" id="userName" value={userName} onChange={(e) => setUserName(e.target.value)} type="text" />
        <Input iconSrc={Padlock} placeholderText="Password" name="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} type="password" />
        <Input iconSrc={Padlock} placeholderText="Confirm Password" name="confirmpassword" id="confirmpassword" value={confirmpassword} onChange={(e) => setConfirmPassword(e.target.value)} type="password" />
        <Button isGold isBig isMarginTop>Register</Button>
        <SmallText>
          You already have account? <Link to={"/login"}>Sign in!</Link>
        </SmallText>
      </FormField>
    </>
  )
}

export default Register