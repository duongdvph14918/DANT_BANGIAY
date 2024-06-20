app.controller("style-ctrl", function ($scope, $http) {
	//alert("style-ctrl")
	$scope.items = [];
	$scope.form = [];
	$scope.cates = [];

	var check ;
	$scope.initialize = function () {
		//load product
		$http.get("/rest/style").then(resp => {
			$scope.items = resp.data;
			$scope.reset();
		})

	}
	$scope.reset1 = function () {
		//alert("reset")
		$scope.form = {
			status: true,
		
		}
	}
	//khởi đầu
	$scope.initialize();
	//xóa form
	$scope.reset = function () {
		//alert("reset")
		$scope.form = {
			styleId: $scope.form.styleId,
			status: true,
			image: 'cloud-upload.jpg',
		}
	}
	//hiện lên form
	$scope.edit = function (item) {
		//alert("edit")
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(1)").tab('show')
	}

	$///tìm kiếm
    $scope.timKiem = function () {
        var name = document.getElementById("keyword").value;
        var trangThai = document.getElementById("trangThai").value;
        if (trangThai == "") {
            trangThai = null;
            //alert("Tìm Kiếm: " + name + " trang thai= " + trangThai)
            $http.get(`/rest/style/timKiem/${name}/${trangThai}`).then(resp => {
                $scope.items = resp.data;
            })
        } else {
            $http.get(`/rest/style/timKiem/${name}/${trangThai}`).then(resp => {
                $scope.items = resp.data;
            })
        }
       
    }
    $scope.genderStart = function (obj) {
        var trangThai = document.getElementById("trangThai").value;
        //alert("Trang thái " + trangThai )
        if (trangThai == "") {
            $http.get("/rest/style").then(resp => {
                $scope.items = resp.data;
            })
        } else {
            $http.get(`/rest/style/timKiem/${trangThai}`).then(resp => {
                $scope.items = resp.data;
            })
        }

    }
    
	//Thêm mới
	$scope.create = function () {
		//alert("Create ")
		var item = angular.copy($scope.form);
		
		var styleName = document.getElementById("styleName").value;
		if(styleName.trim() =="" || styleName ==null){
			alert("Tên mặt kính không được để trống");
			return false;
		}
		//alert("Tên Thương Hiệu " + item.name)
		$http.get(`/rest/style/${item.name}`).then(resp =>{
			if (resp.data == '') {
				//alert("Thương hiệu mới")
				$http.post(`/rest/style`, item).then(resp => {
					$scope.items.push(resp.data);
					$scope.initialize();
					alert("Thêm mới thành công!");
					$(".nav-tabs a:eq(0)").tab('show')
				}).catch(error => {
					alert("Thêm mới thất bại");
					console.log(error);
				});
			} else {
				alert("Đã có mặt kính này")
				console.log(resp.data)
			}
		})		


	}

	//cập nhật 
	$scope.update = function () {
		//alert("update ")
		var item = angular.copy($scope.form);
		//alert("styleId " + item.discountId); 
		var styleName = document.getElementById("styleName").value;
		if(styleName.trim() =="" || styleName ==null){
			alert("Tên mặt kính không được để trống");
			return false;
		}
		$http.put(`/rest/style/${item.styleId}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.styleId == item.styleId);
			$scope.items[index] = item;
			alert("Cập nhật thành công");
			$(".nav-tabs a:eq(0)").tab('show')
		}).catch(error => {
			alert("Xảy ra lỗi trong quá trình cập nhật " + error)
			console.log("error", error);
		})
	}
	//xóa 
	$scope.delete = function (item) {
		//alert("delete")
		var t = confirm("Bạn muốn xóa");
		if (t == false) {
			//alert("Không Xóa");
		} else {
			//alert("có xóa");
			/*$http.delete(`/rest/style/${item.styleId}`).then(resp => {
				var index = $scope.items.findIndex(p => p.styleId == item.styleId);
				$scope.items.splice(index, 1);
				$scope.reset();
				alert("Xóa Thành Công");
			})
				.catch(error => {
					alert("Lỗi xóa!")
					console.log("Error", error);
				})*/
				
			$http.put(`/rest/style/delete/${item.styleId}`, item).then(resp => {
				var index = $scope.items.findIndex(p => p.styleId == item.styleId);
				$scope.items[index] = item;
				alert("xóa thành công");
				$scope.initialize();
			}).catch(error => {
				alert("Lỗi xóa " + error)
				console.log("error", error);
			})	

		}
	}

	$scope.check = function (name){
		$http.get(`/rest/style/${name}`).then(resp =>{
			if (resp.data == '') {
				//alert("Không tìm thấy  " + name)
				check = true;
			} else {
				//alert("Tìm thấy  " + name)
				check = false;
				console.log(resp.data)
			}
		})
	}


	//upload hình
	$scope.imageChanged = function (files) {
		//alert("hìn")
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình" + error);
			console.log("Error", error);
		})
	}


	$scope.pager = {
		page: 0,
		size: 10,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count(){
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first(){
			this.page = 0;
		},
		prev(){
			this.page--;
			if(this.page < 0){
				this.last();
			}
		},
		next(){
			this.page++;
			if(this.page >= this.count){
				this.first();
			}
		},
		last(){
			this.page = this.count - 1;
		}
	}
});