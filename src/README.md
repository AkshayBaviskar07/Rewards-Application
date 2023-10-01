# Rewards Application

### This is the applications where reawards points are calculating in background thread.

**How this application actually works?**

* User will ask login creadential then a thread will check login credential
   * if creadential matches then the _backgrond thread_ will generate random transaction amount.On every 100/- spent, you will get 1 point as reward and user can reddem these points to purchase various items in available categories.
   * When user reddem any reaward it add to list and the list will displayed.
   * if credential not matches then it will ask one more time if another time credential not matches with records then _program will stop_


