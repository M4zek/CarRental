
import { BrowserRouter as Router } from "react-router-dom";
import { ThemeProvider } from "styled-components";
import { GlobalStyles } from "../assets/styles/GlobalStyles";
import { Props } from "../types/Props";
import { theme } from "../assets/styles/theme";
import { AuthProvider } from "../hooks/useAuth";

const AppProviders = ({ children } : Props) => {

  return (
    <Router>
      <ThemeProvider theme={theme}>
        <AuthProvider>
          <GlobalStyles />
          {children}
        </AuthProvider>
      </ThemeProvider>
    </Router>
  )
}

export default AppProviders