package jpahook.jpashop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor
public class Address {

    private String city;

    private String street;

    private String zipCode;

    protected Address(){
        // jpa 스팩상 만듬.
        // 상속할 일이 잘 없으므로 protected로 설정
   }
}
