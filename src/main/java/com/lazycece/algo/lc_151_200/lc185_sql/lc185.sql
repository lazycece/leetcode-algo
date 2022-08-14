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

select b.name   as Department
     , a.name   as Employee
     , a.salary as Salary
from (
         select name
              , salary
              , departmentId
              , dense_rank() over(partition by departmentId order by salary desc ) as rk
         from Employee
     ) a
         inner join Department b
                    on a.rk <= 3 and a.departmentId = b.id
;
