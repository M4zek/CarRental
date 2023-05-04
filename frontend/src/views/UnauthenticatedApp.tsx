import { useContext } from 'react';
import { AppContext } from './Root';
import { FormWrapper } from './UnauthenticatedApp.styles';
import { Route, Switch, Redirect } from 'react-router-dom';
import Register from './Register';
import Login from './Login';

const UnauthenticatedApp = () => {

  const { currentPath } = useContext(AppContext);
  let endpoint: string = currentPath;

  return (
    <FormWrapper>
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
    </FormWrapper>
  )
}

export default UnauthenticatedApp