import { useContext } from 'react';
import { AppContext } from './Root';
import { Wrapper } from "./Root.styles"
import { Route, Switch, Redirect } from 'react-router-dom';
import BackgroundImage from '../assets/images/bg-waves.svg';
import Register from './Register';
import Login from './Login';

const WrapperAdditionalStyles = {
  backgroundImage: `url(${BackgroundImage})`,
  backgroundRepeat: 'no-repeat',
  backgroundSize: 'cover',
};

const UnauthenticatedApp = () => {

  const { currentPath } = useContext(AppContext);
  let endpoint: string = currentPath;

  return (
    <Wrapper style={WrapperAdditionalStyles}>
      <Switch>
        <Route exact path="/">
          <Redirect to="/login" />
        </Route>
        <Route exact path="/login">
          <Login endpoint={endpoint} />
        </Route>
        <Route exact path="/register">
          <Register endpoint={endpoint} />
        </Route>
        <Route path="*">
          <Redirect to="/login" />
        </Route>
      </Switch>
    </Wrapper>
  )
}

export default UnauthenticatedApp