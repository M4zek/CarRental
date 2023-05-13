import { Wrapper } from "./Root.styles";
import { Route, Switch, Redirect } from 'react-router-dom';
import MainTemplate from "../components/templates/MainTemplate";
import { ViewWrapper } from "../components/molecules/ViewWrapper/ViewWrapper";
import AboutUs from "./AboutUs";
import LogoutPage from "./Logout";

const AuthenticatedApp = () => {
  return (
    <MainTemplate>
      <Wrapper>
        <Switch>
          <Route exact path="/">
            <ViewWrapper>Strona główna</ViewWrapper>
          </Route>
          <Route exact path="/cars">
            <ViewWrapper>Samochody</ViewWrapper>
          </Route>
          <Route exact path="/offer">
            <ViewWrapper>Oferta</ViewWrapper>
          </Route>
          <Route exact path="/informations">
            <ViewWrapper>Informacje</ViewWrapper>
          </Route>
          <Route exact path="/about-us">
            <ViewWrapper><AboutUs /></ViewWrapper>
          </Route>
          <Route exact path="/logout">
            <ViewWrapper><LogoutPage /></ViewWrapper>
          </Route>
          <Route path="*">
            <Redirect to="/" />
          </Route>
        </Switch>
      </Wrapper>
    </MainTemplate>
  )
}

export default AuthenticatedApp