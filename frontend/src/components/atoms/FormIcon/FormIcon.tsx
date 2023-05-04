import { ReactComponent as LoginIcon } from '../../../assets/icons/login-icon.svg'
import { ReactComponent as RegisterIcon } from '../../../assets/icons/register-icon.svg';
import { Circle } from './FromIcon.styles';

const FormIcon = ({endpoint}) => (
  <Circle>
    {endpoint === "/register" ? <RegisterIcon /> : <LoginIcon />}
  </Circle>
);

export default FormIcon;