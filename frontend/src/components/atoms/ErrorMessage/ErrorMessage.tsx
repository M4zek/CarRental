import styled from "styled-components";

const hexToRgb = (hex) => {
  const r = parseInt(hex.slice(1, 3), 16);
  const g = parseInt(hex.slice(3, 5), 16);
  const b = parseInt(hex.slice(5, 7), 16);
  return `${r}, ${g}, ${b}`;
};

const hexToRgba = (hex, opacity) => {
  const rgbValue = hexToRgb(hex);
  return `rgba(${rgbValue}, ${opacity})`;
};

export const ErrorMessage = styled.div`
  color: ${({ theme }) => theme.colors.error};
  background-color: ${({ theme }) => hexToRgba(theme.colors.error, 0.1)};
  border: 1px solid ${({ theme }) => theme.colors.error};
  margin-bottom: 1rem;
  padding: 0.5rem 1rem;
  border-radius: 5px;
  font-size: ${({ theme }) => theme.fontSize.m};
`;