import styled from 'styled-components';

export const Wrapper = styled.div`
  width: 100%;
  height: 100vh;
  display: grid;
  grid-template-rows: 68px 1fr;
  color: ${({ theme }) => theme.colors.black};
  background-color: ${({ theme }) => theme.colors.lightGrey};
`;