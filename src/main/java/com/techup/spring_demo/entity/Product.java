package com.techup.spring_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table(name = "products") // ระบุชื่อตารางเป็น "products" เพื่อหลีกเลี่ยง reserved keyword "product"
@Data // สร้าง getter/setter/toString/equals/hashCode ให้อัตโนมัติ
@NoArgsConstructor // Constructor ว่าง (จำเป็นสำหรับ JPA)
@AllArgsConstructor // Constructor ที่มีทุก field
@Builder // ใช้สর้าง object แบบ chain
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @Column(nullable = false, unique = true) // ห้ามซ้ำ ห้ามว่าง
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String imageUrl;
    
}