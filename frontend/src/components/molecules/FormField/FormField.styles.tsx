import styled from "styled-components";

export const StyledForm = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;
  width: 380px;
  /* min-height: 380px; */
  padding: 84px 42px 42px;
  background: ${({ theme }) => theme.colors.white};
  box-shadow: 0px 8px 4px rgba(0, 0, 0, 0.25);
  border-radius: 25px;
`;