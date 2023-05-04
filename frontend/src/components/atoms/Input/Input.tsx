// import styled from "styled-components";
// import { ReactComponent as Person } from "../../../assets/icons/person.svg";

// export const StyledInput = styled.input`
//   filter: drop-shadow(0px 6px 4px rgba(0, 0, 0, 0.25));
//   padding: 11px 33px;

// `;


import styled from 'styled-components';

const InputContainer = styled.div`
  display: flex;
  align-items: center;
  border: 2px solid ${({ theme }) => theme.colors.grey};
  border-radius: 5px;
  padding: 10px;
  margin-bottom: 12px;

  &:focus-within {
    border-color: ${({ theme }) => theme.colors.darkGrey};
  }
`;

const InputIcon = styled.img`
  height: 15px;
  margin-right: 7px;
`;

const InputField = styled.input`
  border: none;
  flex: 1;
  font-size: 16px;
  outline: none;
  font-weight: 700;
  color: ${({ theme }) => theme.colors.darkGrey};
`;

const Input = ({ iconSrc, placeholderText, ...rest }) => {
  return (
    <InputContainer>
      <InputIcon src={iconSrc} />
      <InputField placeholder={placeholderText} {...rest} />
    </InputContainer>
  );
};

export default Input;