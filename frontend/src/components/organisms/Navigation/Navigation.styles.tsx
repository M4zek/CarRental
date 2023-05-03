import styled from "styled-components";
import { NavLink } from 'react-router-dom';

export const Wrapper = styled.nav`
  width: 100%;
  height: 68px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  background-color: ${({ theme }) => theme.colors.darkNavy};
  color: ${({ theme }) => theme.colors.grey};
  padding: 0 1rem;
`;

export const Logo = styled(NavLink)`
  height: 68px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const LinksContainer = styled.div`
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

const activeClassName = 'active-link';
export const StyledLink = styled(NavLink).attrs({ activeClassName })`
  cursor: pointer;
  font-weight: bold;
  text-decoration: none;
  color: ${({ theme }) => theme.colors.grey};
  display: flex;
  flex-direction: row;
  margin: 1rem 1rem 1rem 1rem;

  &.${activeClassName} {
    color: ${({ theme }) => theme.colors.white};
  }

`;