import { Wrapper } from "./Root.styles";
import { Route, Switch } from 'react-router-dom';

const AuthenticatedApp = () => {
  return (
    <Wrapper>
      <Switch>
        <Route exact path="/">Strona główna</Route>
        <Route exact path="/cars">Samochody</Route>
        <Route exact path="/offer">Oferta</Route>
        <Route exact path="/informations">Informacje</Route>
        <Route exact path="/about-us">O nas</Route>
      </Switch>
    </Wrapper>
  )
}

export default AuthenticatedApp