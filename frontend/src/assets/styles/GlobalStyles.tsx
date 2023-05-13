import { createGlobalStyle } from 'styled-components';

export const GlobalStyles = createGlobalStyle`

  html {
    box-sizing: border-box;
  }
  
  *, *::after, *::before {
    box-sizing: inherit;
    font-family: 'Inter', sans-serif;
  }
  
  body {
    font-family: 'Inter', sans-serif;
    margin: 0;
    padding: 0;
    overflow-y: hidden;
    background-color: ${({ theme }) => theme.colors.darkBlue};
    color: ${({ theme }) => theme.colors.white};
  }
  
  a, button {
    font-family: 'Inter', sans-serif;
  }
`;