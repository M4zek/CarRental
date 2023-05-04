import { Wrapper } from "./Root.styles";
import { Route, Switch, Redirect } from 'react-router-dom';
import MainTemplate from "../components/templates/MainTemplate";

const AuthenticatedApp = () => {
  return (
    <MainTemplate>
      <Wrapper>
        <Switch>
          <Route exact path="/">Strona główna</Route>
          <Route exact path="/cars">Samochody</Route>
          <Route exact path="/offer">Oferta</Route>
          <Route exact path="/informations">Informacje</Route>
          <Route exact path="/about-us">O nas</Route>
          <Route path="*">
            <Redirect to="/" />
          </Route>
        </Switch>
      </Wrapper>
    </MainTemplate>
  )
}

export default AuthenticatedApp