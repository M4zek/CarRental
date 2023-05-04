import { StyledForm } from "./FormField.styles"

const FormField = ({children}) => {


  const handleSubmit = (e) => {
    e.preventDefault();
  };

  return (
    <StyledForm as="form" onSubmit={handleSubmit}>
      {children}
    </StyledForm>
  )
}

export default FormField