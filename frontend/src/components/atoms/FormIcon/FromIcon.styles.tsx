import styled from 'styled-components';

export const Circle = styled.div`
  position: absolute;
  z-index: 1;
  top: 0;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 87px;
  height: 87px;
  margin: 0 10px;
  background-color: ${({ theme }) => theme.colors.gold};
  border-radius: 50px;
  border: none;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  filter: drop-shadow(0px 6px 4px rgba(0, 0, 0, 0.25));

  svg {
    width: 40px;
    height: 40px;
  }
`;