SkillFactory (on-line study platform) final project for speciality "Java-Developer" (stream Java-34).
Prototype REST API back-end part for typical web-bank client.

06-jan-2024.
Stage #1 (work with balance).
Released three (REST) methods:
1. getBalance ("/getBalance/{user_id}")
   in right case return JSON like {"id":1,"balance":15000.00},
   in wrong case - {"statusCode":-1,"message":"User with ID=0 not found / not exist.","timestamp":"2024-01-06T16:04:18.903+00:00"}.
2. putMoney (PUT "/putMoney/{user_id}/{income}")
   in right case return JSON like {"statusCode":1,"timestamp":"2024-01-06T16:13:46.995+00:00"},
   in wrong case - {"statusCode":0,"message":"User with ID=4 not found / not exist.","timestamp":"2024-01-06T16:13:52.773+00:00"}.
3. takeMoney (PUT "/putMoney/{user_id}/{income}")
   in right case return JSON like {"statusCode":1,"timestamp":"2024-01-06T16:13:46.995+00:00"},
   in wrong case - {"statusCode":0,"message":"User with ID=4 not found / not exist.","timestamp":"2024-01-06T16:13:52.773+00:00"}
   or {statusCode":0,"message":"Operation: draw can't be executed. User with ID=3 current balance lesser than draw.","timestamp":"2024-01-06T16:13:52.773+00:00"}.
