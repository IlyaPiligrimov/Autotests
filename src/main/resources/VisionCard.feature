Feature: Тестирование визитки
  Background:
    Given:User in site
    @hooks
      @close
    Scenario Outline:
      When ClickLanguage
      And ClickToTabs
      When SingIn  '<logins>','<passwords>'
      And FeedBack
      Then Check
      Examples:
        |logins                    |passwords
        |    "222222223@gmail.com" |"123456"
        |    "322222223@gmail.com" |"123456"


