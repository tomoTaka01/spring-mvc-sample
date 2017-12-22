## Spring Boot Sample for validation

  * as of Spring Boot Version 2.0.0.M7

### How to use validation function
  * PersonForm.java
    * just put annotaions like @NotEmpty to the target columns.

```Java
public class PersonForm {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Max(100)
    private Integer age;

    @Past
    @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate birthDay;

    @Digits(integer=10, fraction = 0)
    @NumberFormat(pattern = "#,###")
    private BigDecimal salary;
```

  * PersonController.java
    * use @Validated annotation to valid the form each column which is annotated by constraints.

```Java
@Controller
@RequestMapping("/person")
public class PersonController {
    ...

    @PostMapping("/valid")
        public String valid(@Validated PersonForm personForm, BindingResult bindingResult) {
        ...
        return "person";
        }
}
```

### How to customize error message
  * I put the messages.properties in the resources directory.
```property
# for form column of error message
firstName=名
lastName=姓
age=年齢
birthDay=誕生日
salary=給与
# for validation error message
NotEmpty={0}は、必須です。
Max={0}は、{1}文字までで入力してください。
Max.personForm.age={0}は、{1}歳までで入力してください。
Digits={0}は、整数部{2}文字で入力してください。
Past={0}は、過去の日を入力してください。
typeMismatch.personForm.java.lang.Integer={0}は、数値で入力してくださいね。
typeMismatch.personForm.age={0}は、数値で入力してください。
typeMismatch.java.math.BigDecimal={0}は、金額で入力してください
typeMismatch.java.time.LocalDate={0}は、日付けを入力してください
```

[sample form](./validation.png)

