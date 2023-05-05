import styled from "styled-components";

export const SmallText = styled.small`
  color: ${({ theme }) => theme.colors.black};
  font-size: ${({ theme }) => theme.fontSize.s};
  margin-top: 0.5rem;
`;