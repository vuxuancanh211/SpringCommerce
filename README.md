Nguyên tắc phát triển phần mềm:
  - Mã nguồn dễ bảo trì, mở rộng và tái sử dụng:
      + Ứng dụng tuân theo nguyên tắc SOLID để đảm bảo rằng mã nguồn dễ đọc, dễ mở rộng mà không ảnh hưởng đến các phần khác.
      + Separation of Concerns (SoC): Chia nhỏ các trách nhiệm trong ứng dụng thành các lớp hoặc thành phần riêng biệt như Controller, Service, và Repository.
  - Dependency Injection (DI):
      + Sử dụng DI để quản lý phụ thuộc giữa các lớp, giúp giảm sự phụ thuộc chặt chẽ (tight coupling) giữa các thành phần.
Mẫu phát triển phần mềm:
  - Kiến trúc RESTful API:
    + Tương tác giữa máy khách và máy chủ dựa trên giao thức HTTP với các phương thức tiêu chuẩn: GET, POST, PUT, DELETE.
    + Dữ liệu được truyền qua các định dạng phổ biến như JSON.
Layered Architecture:
  - Kiến trúc ứng dụng chia thành các lớp: Controller, Service, và Repository.
    
Backend:
  - Công nghệ:
    + Spring Boot: Tạo RESTful API và quản lý các thành phần backend.
  - Các folder chính:
    + Controller:Chứa các lớp điều khiển chịu trách nhiệm xử lý các yêu cầu HTTP từ client.
    + Model: Đại diện cho các đối tượng dữ liệu (entities) tương ứng với bảng trong cơ sở dữ liệu.
    + Repository: Chứa các interface kế thừa từ JpaRepository để tương tác với cơ sở dữ liệu.
    + Service:
        - Chứa các interface service mô tả các chức năng của ứng dụng.
        - Các class implement tương ứng chứa logic xử lý cụ thể.
  - Security: Quản lý cấu hình bảo mật, xác thực bằng Spring Security và JWT.


Full CURL commands or Postman snapshots to verify the APIs including request endpoints, HTTP Headers and request payload if any.
1. Product
   a. GetProducts
     ![image](https://github.com/user-attachments/assets/16b9707e-4215-4b05-af78-0618f058c968)
   b. GetProductById
     ![image](https://github.com/user-attachments/assets/f5f45f8b-b168-4593-9242-6abc86c92e96)
   c. AddProduct
     ![image](https://github.com/user-attachments/assets/089da7f5-5450-46c7-9cd2-6f37d9b7f73b)
   d. UpdateProduct
     ![image](https://github.com/user-attachments/assets/6a9e946b-f113-4775-b084-f67353a2a0f2)
   e. DeleteProduct
     ![image](https://github.com/user-attachments/assets/fd165665-87de-49f2-ac0b-cc4bc69267a6)

2. Order
   a. GetOrders
     ![image](https://github.com/user-attachments/assets/07a6428c-218f-480e-8a8a-bc7836658c38)
   b. GetOrderById
     ![image](https://github.com/user-attachments/assets/3cf56cb7-b7e2-44bf-b628-fddbdaca339c)
   c. AddOrder
     ![image](https://github.com/user-attachments/assets/42cf4073-8fc3-46b4-8a01-ab109f9f3d18)
   d. Update Order
     ![image](https://github.com/user-attachments/assets/4e985955-e469-41fc-8103-b4091ad44d12)
   e.DeleteOrder
     ![image](https://github.com/user-attachments/assets/62b413e4-81ff-446c-a23a-143a9ce897ab)









