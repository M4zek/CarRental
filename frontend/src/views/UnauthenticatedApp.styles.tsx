import styled from "styled-components";
import BackgroundImage from '../assets/images/bg-waves.svg';

export const FormWrapper = styled.div`
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-image: url(${BackgroundImage});
  background-repeat: no-repeat;
  background-size: cover;
`;