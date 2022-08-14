/*
 *    Copyright 2022 lazycece<lazycece@gmail.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */


SELECT *
FROM (
         SELECT DISTINCT l3.num AS ConsecutiveNums
         FROM Logs l1
                  LEFT JOIN Logs l2
                            ON l1.Id = l2.Id - 1 and l1.num = l2.num
                  LEFT JOIN Logs l3
                            ON l2.id = l3.id - 1 and l2.num = l3.num
     ) t
WHERE ConsecutiveNums is not null
;