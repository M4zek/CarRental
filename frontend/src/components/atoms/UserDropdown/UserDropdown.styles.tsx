import styled from "styled-components";

export const Container = styled.div`
  position: relative;
  height: 100%;
  `;

export const Button = styled.button`
  height: 100%;
  display: flex;
  gap: 0.5rem;
  align-items: center;
  background-color: transparent;
  border: none;
  color: ${({ theme }) => theme.colors.white};
  cursor: pointer;

  & span::after {
    display: inline-block;
    margin-left: .255em;
    vertical-align: .255em;
    content: "";
    border-top: .3em solid;
    border-right: .3em solid transparent;
    border-bottom: 0;
    border-left: .3em solid transparent;
  }
`;

export const Dropdown = styled.div`
  position: absolute;
  top: 100%;
  right: 0;
  padding: 0.25rem;
  background-color: ${({ theme }) => theme.colors.white};
  border: 1px solid ${({ theme }) => theme.colors.gray};
  border-top: none;
  border-radius: 0 0 0.25rem 0.25rem;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 1;
  display: ${({ open }) => (open ? "block" : "none")};
  `;

export const DropdownItem = styled.div`
  cursor: pointer;
  width: 100%;
  padding: 0.5rem;
  font-size: 0.875rem;
  border-radius: 0.25rem;
  
  & a {
    width: 100%;
    display: inline-block;
    text-decoration: none;
    color: ${({ theme }) => theme.colors.black};
  }

  &:hover {
    background-color: ${({ theme }) => theme.colors.lightGrey};
  }
`;