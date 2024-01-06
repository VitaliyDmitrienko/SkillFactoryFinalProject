SkillFactory (on-line study platform) final project for speciality "Java-Developer" (stream Java-34).
Prototype RESTfull API back-end part for standart web-bank client.

06-jan-2024.
Stage #1 (work with balance).
Released three (REST) methods:
1. getBalance ("/getBalance/{user_id}")
   in right case return JSON like {"id":1,"balance":15000.00},
   in wrong case - {"statusCode":-1,"message":"User with ID=0 not found / not exist.","timestamp":"2024-01-06T16:04:18.903+00:00"}.
2. putMoney ("/putMoney/{user_id}/{income}")
   in right case return JSON like {"statusCode":1,"timestamp":"2024-01-06T16:13:46.995+00:00"},
   in wrong case - {"statusCode":0,"message":"User with ID=4 not found / not exist.","timestamp":"2024-01-06T16:13:52.773+00:00"}.
