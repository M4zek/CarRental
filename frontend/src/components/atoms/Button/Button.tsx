import styled from "styled-components";

export const Button = styled.button`
  /* height: 33px; */
  cursor: pointer;
  background: ${({isGold, theme}) => (isGold ? theme.colors.gold : theme.colors.blue)};
  box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 5px;
  color: ${({ theme }) => theme.colors.white};
  font-weight: bold;
  padding: 0.5rem;
  padding: ${({isBig}) => (isBig ? `0.7rem` : `0.5rem`)};
  margin-top: ${({isMarginTop}) => (isMarginTop ? `1rem` : `0`)};
  margin-bottom: 0.5rem;
  border: none;
`;