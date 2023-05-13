import { Wrapper } from "./MainTemplate.styles";
import { Props } from "../../types/Props";
import Navigation from "../organisms/Navigation/Navigation";

const MainTemplate = ({ children } : Props) => {
  return (
    <Wrapper>
      <Navigation />
      {children}
    </Wrapper>
  )
}

export default MainTemplate